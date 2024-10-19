import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


abstract class FileManager {

    public static String[] csvSeparator(String csvLine)
    {

        return csvLine.split(";");

    }

    public static ArrayList<Pessoa> csvSeparator(File csvFile){

        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        
        try{
            Scanner scan = new Scanner(csvFile);

            //ID;NomeUsuario;Senha;NivelDeAcesso;Nome;Idade;CPF
            while(scan.hasNextLine()){
                String[] valores = csvSeparator(scan.nextLine());

                //Confere se o valor é diferente de ID
                if(!valores[0].toLowerCase().equals("id")){

                    pessoas.add(new Pessoa(
                        Commom.ToInt(valores[0]),
                        valores[4],
                        Commom.ToInt(valores[5]),
                        valores[6],
                        new Login(
                            valores[1], 
                            valores[2],
                            Commom.ToInt(valores[3]))
                    ));
                }
            }
         
            scan.close();
            return pessoas;

        }
        catch(Exception e){

            return pessoas;
        }
        
    }



    
}
