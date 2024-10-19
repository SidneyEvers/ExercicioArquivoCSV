import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        /*
        
         * Crie um programa que contenha Login e Senha de três contas,
         * solicite ao usuário um login e senha, caso estejam corretos
         * mostre na tela “Login efetuado” caso contrário mostre “Login
         * ou senha inválidos”
         */

         //Este é o arquivo
         File myFile = new File("C:\\Users\\74682\\Documents\\Usuarios.csv");

         if(myFile.exists()){
          System.out.println("Arquivo já existia -> " + myFile.getName());
         } 
         else{
          System.out.println("Arquivo foi criado com o nome de " + myFile.getName());
         }

         ArrayList<Pessoa> pessoas = FileManager.csvSeparator(myFile);

        System.out.println("Insira o UserName");
        String tempUser = scan.nextLine();
        System.out.println("Insira o Password");
        String tempPass = scan.nextLine();

          /*
            Todas as contas podem trocar a própria senha e dar LogOut.
            4 < Nível de acesso < 8, pode trocar a senha de outros usuários com nível inferior
            Nível de acesso >= 8 pode trocar a senha de outros usuários com nível inferior e pode excluir e incluir usuários de nível inferior.
           */




        boolean encontrado = false;
        for (int i = 0; i < pessoas.size(); i++) {
            
            if(pessoas.get(i).getAccount().EfetuaLogin(tempUser, tempPass)){
                System.out.println("Login Efetuado");
                encontrado = true;
                break;
            }
        }
        if(encontrado == false){
            System.out.println("User ou pass invalido");
        }
        //     if (pessoas.get(i).getUserName().equals(temp)) {
        //         System.out.println("Insira a senha");
        //         temp = scan.nextLine();
        //         encontrado = true;
        //         if (logins[i].getPassWord().equals(temp))
        //         {
        //             System.out.println("Logado com sucesso");
        //             break;
        //         }
        //         else
        //         {
        //             System.out.println("Password incorreto");
        //             break;
        //         }
        //     }
        // }
        // if (encontrado == false)
        // {
        //     System.out.println("User ou Pass inválidos");
        // }

        // scan.close();

       
        //Este é o leitor do arquivo
        // Scanner fileManeger = new Scanner(myFile);
        //Este é o escritor do arquivo
        //FileWriter fileInput = new FileWriter(myFile);



        // while(fileManeger.hasNextLine()){
        //     System.out.println(fileManeger.nextLine());
        // }

        // fileInput.write("Meu Arquivo deu certo novo");
        // fileInput.append("\nTop demais");

       
        // fileManeger.close();
        //fileInput.close();
        

        

    }
}
