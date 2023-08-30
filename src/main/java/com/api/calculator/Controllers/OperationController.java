package com.api.calculator.Controllers;

import com.api.calculator.utils.Utils;
import com.api.calculator.Models.Operation;
import com.api.calculator.Services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Thread.sleep;

@RestController
@RequestMapping("/api")
public class OperationController {
    @Autowired
    private OperationService operationService;

    @PostMapping("/do-math")
    public String do_math(@RequestBody List<Operation> operationList) throws Exception {
        List<Double> results = new ArrayList<>();

        for (Operation operation: operationList) {
            Double result = operationService.calc_result(operation);
            operation.setResult(result);
            results.add(result);
            sleep(500);
        }
        return Utils.writeToFile(results);
    }

    @GetMapping("/check-finished")
    public boolean checkFinished (@RequestParam ("filename") String fileName) {
        File file = new File(fileName);
        return file.exists();
    }

}
