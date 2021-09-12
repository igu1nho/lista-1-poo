package br.inatel.cdg.algebra.scene;

import br.inatel.cdg.algebra.reta.Ponto;
import br.inatel.cdg.algebra.reta.Reta;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScenePrincipal {

    private Button bttCoefAng, bttCoefLin; //Botoes para realizar o calculo
    private Label lp1X, lp1Y, lp2X, lp2Y; //Rótulos dos pontos em cada coordenadas x e y
    private TextField tp1X,tp1Y,tp2X,tp2Y, tCoefAng, tCoefLin; //Campo de texto para as coordenadas e para os coeficientes

    public void criaScenePrincipal(Stage stage){

        //Criando os labels para os pontos e os campos de texto para os dados
        lp1X = new Label("Ponto P1 de X"); //rótulos
        tp1X = new TextField(); //área de texto

        lp1Y = new Label("Ponto P1 de Y");
        tp1Y = new TextField();

        lp2X = new Label("Ponto P2 de X");
        tp2X = new TextField();

        lp2Y = new Label("Ponto P2 de Y");
        tp2Y = new TextField();

        //HBox é usado para agrupar elementos horizontalmente
        HBox hbp1X = new HBox(lp1X, tp1X); //Cria-se quatro grupos horizontais com Rótulo e Área de Texto para as coordenadas x e y
        HBox hbp1Y = new HBox(lp1Y, tp1Y);
        HBox hbp2X = new HBox(lp2X, tp2X);
        HBox hbp2Y = new HBox(lp2Y, tp2Y);

        //VBox é usada para agrupar elementos verticalmente
        //No construtor passamos todos os elementos que serão agrupados
        VBox vboxEntradaCoord = new VBox(hbp1X,hbp1Y,hbp2X,hbp2Y);//Agrupar-se verticalmente os pontos para o usuário entrar com as coordenadas dos pontos

        //Caixas de texto que apresentaremos o resultado
        tCoefAng = new TextField();
        tCoefAng.setEditable(false);//"false" para evitar que o usuário digite alguma coisa nessas caixas
        tCoefAng.setText("Coef Angular: ");

        tCoefLin = new TextField();
        tCoefLin.setEditable(false);
        tCoefLin.setText("Coef Linear: ");

        //Agrupar as áreas onde o resultado será apresentado
        HBox hboxRespostas = new HBox(tCoefAng,tCoefLin);

        //Criando o botão
        bttCoefAng= new Button("Calcular o Coeficiente Angular");
        //Criando a ação que o botão responderá ao ser pressionado
        bttCoefAng.setOnAction(evento -> {
            Reta reta = construirReta();
            tCoefAng.setText("Coef Angular: " + reta.calcCoeficienteAngular());//Acesso do componente tCoefAng para colocar o resultado do cálculo
        });

        bttCoefLin = new Button("Calcular o Coeficiente Linear");
        bttCoefLin.setOnAction(evento -> {
            Reta reta = construirReta();
            tCoefLin.setText("Coef Linear: " + reta.calcCoeficienteLinear());
        });

        //Agrupa-se os botões verticalmente
        HBox hBoxBot = new HBox(bttCoefAng,bttCoefLin);


        //Criação do layout vertical final
        VBox layoutFinal = new VBox(vboxEntradaCoord,hboxRespostas, hBoxBot);

        //Criando a Scene
        Scene scene = new Scene(layoutFinal, 300 , 200);

        stage.setTitle("Software Para Calculos de Álgebra Linear");
        stage.setScene(scene);
        stage.show();
    }

    //Função interna que cria uma reta
    private Reta construirReta(){
        Ponto p1 = new Ponto(Double.parseDouble(tp1X.getText()),
                Double.parseDouble(tp1Y.getText()));

        Ponto p2 = new Ponto(Double.parseDouble(tp2X.getText()),
                Double.parseDouble(tp2Y.getText()));

        Reta reta = new Reta(p1,p2);
        return reta;
    }

}
