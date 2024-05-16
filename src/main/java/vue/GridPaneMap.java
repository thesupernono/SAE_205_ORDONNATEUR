package vue;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class GridPaneMap extends GridPane {
    public GridPaneMap(){
        //rends les lignes de la GridPane visible
        this.setGridLinesVisible(true);

        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(20);

        int ligne = 0;

        for(int x=0; x<10; x++){
            this.addColumn(1);
            for(int y=0; y<10; y++){
                Pane cellule = new Pane();
//                cellule.setOnContextMenuRequested(e -> {
//                    menuItem1.setOnAction(evt -> System.out.println("Item 1 selected in cell ["+col+", "+row+"]"));
//                    menuItem2.setOnAction(evt -> System.out.println("Item 2 selected in cell ["+col+", "+row+"]"));
//                });
                cellule.setOnMouseClicked(evenementClique -> {
                    System.out.println("je suis clickée ahhh");
                });
                this.add(cellule, x, y);
            }
        }
    }
}
/**
 * package vue;
 *
 * import javafx.geometry.Insets;
 * import javafx.scene.canvas.Canvas;
 * import javafx.scene.canvas.GraphicsContext;
 * import javafx.scene.control.Label;
 * import javafx.scene.layout.VBox;
 * import javafx.scene.paint.Color;
 * import modele.ConstantesCanvas;
 * import modele.Position;
 *
 * public class VBoxRoot extends VBox implements ConstantesCanvas {
 *     private Label labelNombreDePas;
 *     private Canvas canvasCarte;
 *     private GraphicsContext graphiqueContext2D;
 *     private Position positionApprenti;
 *
 *     VBoxRoot() {
 *         labelNombreDePas = new Label("Nombre de pas : 0");
 *
 *
 *         //-------------------------Map-------------------------
 *         canvasCarte = new Canvas();
 *         canvasCarte.setWidth(LARGEUR_CANVAS);
 *         canvasCarte.setHeight(HAUTEUR_CANVAS);
 *         graphiqueContext2D = canvasCarte.getGraphicsContext2D();
 *
 *
 *         //-----------------Initiation de carrés-----------------
 *         graphiqueContext2D.setStroke(COULEUR_GRILLE);
 *         for (int i = 0; i < LARGEUR_CANVAS; i += CARRE){
 *             for (int j = 0; j < HAUTEUR_CANVAS; j += CARRE){
 *                 graphiqueContext2D.strokeRect(i, j, CARRE, CARRE);
 *             }
 *         }
 *
 *
 *         //--------------------Numero colonne--------------------
 *         int numCol = 1;
 *         graphiqueContext2D.setFill(COULEUR_GRILLE);
 *         for (int i = CARRE; i < LARGEUR_CANVAS; i += CARRE){
 *             graphiqueContext2D.fillText(Integer.toString(numCol), i + CARRE/3, CARRE/2);
 *             numCol ++;
 *         }
 *         int nmbColonne = numCol;
 *
 *
 *         //---------------------Numero ligne----------------------
 *         int numLigne = 1;
 *         graphiqueContext2D.setFill(COULEUR_GRILLE);
 *         for (int i = CARRE; i < HAUTEUR_CANVAS; i += CARRE){
 *             graphiqueContext2D.fillText(Integer.toString(numLigne), CARRE/3, i+CARRE/2);
 *             numLigne++;
 *         }
 *         int nmbLigne = numLigne;
 *
 *
 *         //----------------Composants à la racine----------------
 *         this.getChildren().add(labelNombreDePas);
 *         VBox.setMargin(labelNombreDePas, new Insets(30));
 *         this.getChildren().add(canvasCarte);
 *         VBox.setMargin(canvasCarte, new Insets(30));
 *
 *
 *         //-----------------------Apprenti-----------------------
 *         positionApprenti = new Position(nmbColonne / 2, nmbLigne / 2);
 *         graphiqueContext2D.setFill(COULEUR_APPRENTI);
 *         graphiqueContext2D.fillOval(
 *                 positionApprenti.getAbscisse() * CARRE + CARRE / 8,
 *                 positionApprenti.getOrdonnee() * CARRE + CARRE / 4,
 *                 LARGEUR_OVALE, HAUTEUR_OVALE);
 *
 *
 *         //------------------------Event------------------------
 *         canvasCarte.setOnMouseClicked(event -> {
 *             int abscisse = (int) event.getX() / CARRE;
 *             int ordonnee = (int) event.getY() / CARRE;
 *             Position positionCliquee = new Position(abscisse, ordonnee);
 *             System.out.println(positionCliquee);
 *             graphiqueContext2D.setFill(COULEUR_DESTINATION);
 *             graphiqueContext2D.fillRect(
 *                     positionCliquee.getAbscisse() * CARRE + CARRE / 8,
 *                     positionCliquee.getOrdonnee() * CARRE + CARRE / 4,
 *                     LARGEUR_CIBLE, HAUTEUR_CIBLE);
 *         });
 *     }
 * }
 */