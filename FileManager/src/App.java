import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Executable;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        /*
        
         * Crie um programa que contenha Login e Senha de três contas,
         * solicite ao usuário um login e senha, caso estejam corretos
         * mostre na tela “Login efetuado” caso contrário mostre “Login
         * ou senha inválidos”
         */


          /*
           
        / * Todas as contas podem trocar a própria senha e dar logOut
         * 4 < Nível de acesso < 8, pode trocar a senha de 
         * outros usuários com nível inferior 
         * Nível de acesso >= 8, pode trocar a senha de 
         * outros usuários com o nível inferior e pode excluir e incluir
         * usuários de nível inferior 
         */
         //Este é o arquivo

         File myFile = new File("");
         try{
            myFile = new File("C:\\Users\\74682\\Documents\\Usuarios.csv");

            if(myFile.exists()){
             System.out.println("Arquivo já existia -> " + myFile.getName());
            } 
            else{
             System.out.println("Arquivo foi criado com o nome de " + myFile.getName());
            }
         }catch(Exception e){
            System.out.println("Arquivo não encontrado");
         }
         

         ArrayList<Pessoa> pessoas = FileManager.csvSeparator(myFile);
         Pessoa usuario;
         while(true){
            System.out.println("Insira o UserName");
            String tempUser = scan.nextLine();
            System.out.println("Insira o Password");
            String tempPass = scan.nextLine();

             usuario = BackEnd.EfetuarLogin(pessoas, tempUser, tempPass);
             if(usuario.getId() == -1){
                System.out.println("UserName ou PassWord inválidos");
             }
             else{
                System.out.println("login efetuado com sucesso");
                System.out.println("Seja bem vindo "+ usuario.getAccount().getUserName());
                break;
             }
         }


         while(true){

            Menu(usuario.getAccount().getNivelAcesso());
            int escolha = Commom.ToInt(scan.nextLine());
            if(escolha == 5){
                System.out.println("Logout efetuado.");
                break;
            }else{
                BackEnd.ExecutaComando(pessoas, usuario, escolha, scan);
            }
                      
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
    
    public static void Menu(int nivelAcesso){

        System.out.println("Escolha uma das opções:");
        System.out.println("1 - Mudar a senha");
        if(nivelAcesso > 4 && nivelAcesso < 8){
            System.out.println("2 - Mudar senha de outro usuário");
        }
        else if(nivelAcesso >= 8){
            System.out.println("2 - Mudar senha de outro usuário");
            System.out.println("3 - Adicionar usuário");
            System.out.println("4 - Remover usuário");
        }
        System.out.println("5 - LogOut");
    }
}
