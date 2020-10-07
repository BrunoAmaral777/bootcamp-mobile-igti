package com.example.calculadorasalarioliquido;

import java.text.DecimalFormat;

public class CalculoSalarioUtil {


    public static double CalculoDescontoInss(double salarioBruto){
        double valorDescontoInss = 0;
        double valorAliquotaInss;
        double valorDeducaoInss;

        if (salarioBruto > 0 && salarioBruto <= 1045) {
            valorAliquotaInss = salarioBruto * 0.075;
            valorDescontoInss = valorAliquotaInss;
        } else if (salarioBruto >= 1045.01 && salarioBruto <= 2089.60) {
            valorAliquotaInss = salarioBruto * 0.09;
            valorDeducaoInss = valorAliquotaInss - 15.67;
            valorDescontoInss = valorDeducaoInss;
        } else if (salarioBruto >= 2089.61 && salarioBruto <= 3134.40) {
            valorAliquotaInss = salarioBruto * 0.12;
            valorDeducaoInss = valorAliquotaInss - 78.36;
            valorDescontoInss = valorDeducaoInss;
        } else if (salarioBruto >= 3134.41 && salarioBruto <= 6101.06) {
            valorAliquotaInss = salarioBruto * 0.14;
            valorDeducaoInss  = valorAliquotaInss - 141.05;
            valorDescontoInss = valorDeducaoInss;
        } else if (salarioBruto > 6101.06) {
            valorDescontoInss = 713.10;
        }
        return valorDescontoInss;
    }

    public static double CalculoIrrf(double salarioBruto, int dependentes){
        double calculoBaseIRRF = 0;
        double descontoIRRF = 0;
        final double TAXA_DEPENDENTES = 189.59;

        calculoBaseIRRF = salarioBruto - CalculoDescontoInss(salarioBruto);
        calculoBaseIRRF -= dependentes * TAXA_DEPENDENTES;

        if (calculoBaseIRRF <= 1903.98) {
            descontoIRRF = 0;
        }else if (calculoBaseIRRF >= 1903.99 && calculoBaseIRRF <=2826.65) {
            descontoIRRF = (calculoBaseIRRF * 0.075) - 142.80;
        }else if (calculoBaseIRRF >= 2826.66 && calculoBaseIRRF <=3751.05) {
            descontoIRRF = (calculoBaseIRRF * 0.15) - 354.80;
        }else if (calculoBaseIRRF >= 3751.06 && calculoBaseIRRF <=4664.68) {
            descontoIRRF = (calculoBaseIRRF * 0.225) - 636.13;
        }
        else if (calculoBaseIRRF > 4664.68) {
            descontoIRRF = (calculoBaseIRRF * 0.275) - 869.36;
        }
        return descontoIRRF;
    }

    public static double SalarioLiquido(double salarioBruto, int dependentes, double outrosDescontos){
        return  salarioBruto - CalculoDescontoInss(salarioBruto) - CalculoIrrf(salarioBruto, dependentes) - outrosDescontos;
    }

    public static String PorcentagemDescontosTotais(double salarioBruto, int dependentes, double outrosDescontos){
        String valorProrcentagem;
        double descontoTotal = CalculoDescontoInss(salarioBruto) + CalculoIrrf(salarioBruto, dependentes) + outrosDescontos;
        double descontoPorcentagem = (descontoTotal * 100) / salarioBruto;

        DecimalFormat formatDecimal = new DecimalFormat("#.##");
        valorProrcentagem = formatDecimal.format(descontoPorcentagem).replace(".",",") + "%";
        return  valorProrcentagem;
    }
}
