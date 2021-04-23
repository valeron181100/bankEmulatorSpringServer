package com.kickstarter.bank.contoller;

import com.kickstarter.bank.models.Card;
import com.kickstarter.bank.models.CardHttpRequestBody;
import com.kickstarter.bank.models.CardService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bank")
class CardController {

    @Operation(summary = "Выводит список карт пользователей")
    @GetMapping(path = "/list", produces = "application/json")
    public ResponseEntity listCards() {
        JSONArray array = new JSONArray();
        System.out.println("listing cards");
        CardService.getInstance().getCards().forEach((k,v) -> array.put(v.toJSON()));

        return ResponseEntity.ok().body(array.toString());
    }

    @Operation(summary = "Задонатить деньги")
    @PostMapping(path = "/donate", consumes = "application/json", produces = "application/json")
    public ResponseEntity donate(@RequestBody() CardHttpRequestBody body) {
        System.out.println("new donation");
        CardService service = CardService.getInstance();
        if (!service.checkCard(body.getNumber(), body.getMoney()))
            return ResponseEntity.badRequest().body("{\"response\":\"Неверные данные карты или недостаточно средств\"}");
        service.getCards().get(body.getNumber()).withdrawMoney(body.getMoney());
        return ResponseEntity.ok().body("{\"response\":\"Средства успешно переведены!\"}");
    }
}
