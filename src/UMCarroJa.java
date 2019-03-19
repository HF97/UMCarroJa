import java.util.Scanner;

public class UMCarroJa {

    public void main() throws Exception {
        Programa p = new Programa();
        try{
            p = p.carregaObjetoInformacao();
        }
        catch (Exception e){
            System.out.println("Erro a carregar");
        }
        executa(p);
        try{
            p.gravaObjetoInformacao();
        }catch(Exception e){
            System.out.println("Erro a guardar");
            return;
        }
    }

    private void executa (Programa p) throws Exception {
        Scanner input = new Scanner(System.in);
        int x = -1;
        limparEcra();
        Menu.menuPrincipal();
        while(x!=0 && x!=1 && x!=2){
            x = input.nextInt();
        }
        limparEcra();
        switch(x){
            case (1):
                menuEntrar(p);
                break;
            case(2):
                menuRegistar(p);
                break;
            case(0):
                break;
        }
    }


    private void limparEcra(){
        System.out.print('\f');
    }
}
