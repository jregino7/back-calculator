package com.calculator.Calculator.controllers;
import com.calculator.Calculator.models.salida;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.http.MediaType;

@CrossOrigin("*")
@RestController

public class CalculatorControlador {
    @RequestMapping(value= "/calculator", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public salida operar(@RequestParam(name="op1", required = false, defaultValue="0")String op1,
                         @RequestParam(name="op2", required = false, defaultValue="0")String op2,
                         @RequestParam(name="operation", required = false, defaultValue="None")String operation){



        salida exported = new salida();

        try{
            System.out.println(operation);
            float internalResult =0;
            float castop1 = Float.parseFloat(op1);
            float castop2 = Float.parseFloat(op2);

            if(operation.equals("suma")){
                internalResult=castop1+castop2;}

            else if (operation.equals("resta")){
                internalResult=castop1-castop2;}

            else if (operation.equals("division")){
                if(castop2==0){
                    throw new ArithmeticException();
                }
                internalResult=castop1/castop2;}

            else if (operation.equals("multiplicacion")){
                internalResult=castop1*castop2;}



            else {throw new Exception();}
            exported.setstado("ok");
            exported.setResultado(internalResult);

            }


        catch (NumberFormatException ex ){
            exported.setstado("Error: unos de los operadores no es númerico");
        }
        catch (ArithmeticException zeroEx){
            exported.setstado("Error: no es posible realizar la divicion por cero ");
        }
        catch (Exception misin){
            exported.setstado("Error: no ingreso la operacion requerida ");

        }

        return exported;

    }
}
