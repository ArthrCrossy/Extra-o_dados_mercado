import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Scanner;

import javax.sound.midi.SysexMessage;

public class objeto{

    private int pos;
    private String Date, sku, sku_category;
    private int id_customer, id_transaction;
    private int quantify;
    private double sales_amout; 

    public objeto(){
        this.SetPos(0);
        this.SetDate("");
        this.SetSku("");
        this.SetSkuCategory("");
        this.SetCustomer(0);
        this.SetTransaction(0);
        this.SetQuantify(0);
        this.SetSalesAmout(0.0);
    }

    public objeto(

        int pos,
        String Date,
        String Sku,
        String sku_category,
        int id_customer,
        int id_transaction,
        int quantify,
        double sales_amout
    ){
        this.pos = pos;
        this.Date = Date;
        this.sku = sku;
        this.sku_category = sku_category;
        this.id_customer = id_customer;
        this.id_transaction = id_transaction;
        this.quantify = quantify;
        this.sales_amout = sales_amout;
    }

    public int getPos(){
        return this.pos;
    }

    public int getIdCustomer(){
        return this.id_customer;
    }

    public int getIdTransaction(){
        return this.id_transaction;
    }

    public int getQuantify(){
        return this.quantify;
    }

    public double getSales_amout(){
        return this.sales_amout;
    }

    public String getDate(){
        return this.Date;
    }

    public String getSku(){
        return this.sku;
    }

    public String getSkuCategory(){
        return this.sku_category;
    }

    public void SetPos(int pos){
        this.pos = pos;
    }

    public void SetCustomer(int id_customer){
        this.id_customer = id_customer;
    }

    public void SetTransaction(int id_transaction){
        this.id_transaction = id_transaction;
    }

    public void SetQuantify(int quantify){
        this.quantify = quantify;
    }

    public void SetSalesAmout(double sales_amout){
        this.sales_amout = sales_amout;
    }

    public void SetDate(String date){
        this.Date = date;
    }

    public void SetSku(String sku){
        this.sku = sku;
    }

    public void SetSkuCategory(String sku_category){
        this.sku_category = sku_category;
    }

    public static void main(String[] args){

        File arquivo = new File("./archive/scanner_data.csv");
                                    
        ArrayList<objeto> lista = new ArrayList<>();
        ArrayList<objeto> best_scanner = new ArrayList<>();


        try{
            
            Scanner entrada = new Scanner(arquivo);

            String linha = new String();

            entrada.nextLine();

            while(entrada.hasNext()){

            linha = entrada.nextLine();

            String[] valor = linha.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

            objeto obj = new objeto();

            obj.SetPos(Integer.parseInt(valor[0]));
            obj.SetDate(valor[1]);
            obj.SetCustomer(Integer.parseInt(valor[2]));
            obj.SetTransaction(Integer.parseInt(valor[3]));
            obj.SetSkuCategory(valor[4]);
            obj.SetSku(valor[5]);
            obj.SetSalesAmout(Double.parseDouble(valor[7]));

            lista.add(obj);

            }

        }catch(FileNotFoundException Error){
            System.out.println(Error + "deu ruim");
        }

        for(int i = 0; i < lista.size(); i = i + 1){
            best_scanner.add(lista.get(i));
        }

        for(int i = 0; i < lista.size(); i = i + 1){
            System.out.println(lista.get(i).pos);
        }

        System.out.println(lista.size());
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    }
}