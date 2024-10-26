import java.util.ArrayList;
import java.util.Scanner;

abstract class BackEnd {
    
    public static Pessoa EfetuarLogin(ArrayList<Pessoa> usuarios, String userName, String password){

        for(Pessoa pessoa : usuarios){

            if(pessoa.getAccount().EfetuaLogin(userName, password)){
                return pessoa;
            }
        }

        return new Pessoa(-1);
        
    }

    public static void ExecutaComando(ArrayList<Pessoa> usuarios, Pessoa user, int escolha, Scanner scan){

        if(escolha == 1){
            System.out.println("Qual a nova senha?");
            user.getAccount().setPassWord(scan.nextLine());
        }else if(escolha == 2){
            if(user.getAccount().getNivelAcesso() <= 4){
                AcesIn();
            }else {
                ShowNivel(usuarios, user);
                System.out.println("Qual ID da conta que deseja alterar?");
                int idEscolha = Commom.ToInt(scan.nextLine());
                int index = ChecaNivel(usuarios, user.getAccount().getNivelAcesso(), idEscolha);

                if(index == -1){
                    System.out.println("Seu nível de acesso é baixo");
                }else if(index == -2){
                    System.out.println("Id não encontrado");
                }else{
                    System.out.println("Qual a nova senha?");
                    usuarios.get(index).getAccount().setPassWord(scan.nextLine());
                }


            }
        }else if(escolha == 3){
            System.out.println("Em desenolvimento");
        }else{
            System.out.println("Opção inválida");
        }

    } 


    //Acesso inválido
    private static void AcesIn(){
        System.out.println("Nível de acesso inválido");
    }

    private static void ShowNivel(ArrayList<Pessoa> pessoas, Pessoa user){

        for(int i = 0; i < pessoas.size(); i++){
            if(pessoas.get(i).getAccount().getNivelAcesso() < user.getAccount().getNivelAcesso()){
                System.out.println( pessoas.get(i).toString());
                System.out.println("-----------------");

                
            }
        }

    }

    private static int ChecaNivel(ArrayList<Pessoa> usuarios, int nivelAcesso, int escolhaId){

        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getId() == escolhaId){
                if(usuarios.get(i).getAccount().getNivelAcesso() > nivelAcesso){
                    return -1;
                }else{
                    return i;
                }
            }
        }
        return -2;
    }



}
