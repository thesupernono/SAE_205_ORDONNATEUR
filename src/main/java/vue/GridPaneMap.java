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
