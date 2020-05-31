/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.Departament;
import entities.Enum.WorkerLevel;
import entities.Enum.WorkerLevel;
import entities.HourContract;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dell
 */
public class Worker {

    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    //aqui estão a composição quando é [] 1 --> 1
    private Departament departament;
    //quando é [] 1 --> * muitos[] fica uma lista
    private List<HourContract> contracts = new ArrayList<>();

    public Worker() {
    }
//no construtor eu não gero o que é lista

    public Worker(String name, WorkerLevel level, Double baseSalary, Departament departament) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.departament = departament;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    public List<HourContract> getContract() {
        return contracts;
    }

    public void addContract(HourContract contract) {
        contracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }

    public double income(int year, int month) {

        double sum = baseSalary;
        Calendar cal = Calendar.getInstance(); //criando o objeto cal para usar metodo
        for (HourContract c : contracts) {
            cal.setTime(c.getDate()); //usando metodo para pegar data da lista contido em c
            int c_year = cal.get(Calendar.YEAR); //pegando apenas o ano de dentro do meu cal
            int c_month = 1 + cal.get(Calendar.MONTH);
            if (month == c_month && year == c_year) { //comparando se o que eu peguei com get é igual o que vem com o parametro
                sum += c.totalValues(); // se sim eu somo os valores dos contratos
            }
        }
        return sum; //retorno as somas apenas do mes e ano verificados
    }
}
