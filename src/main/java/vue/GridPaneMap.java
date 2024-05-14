package vue;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class GridPaneMap extends GridPane {
    public GridPaneMap(){
        //rends les lignes de la GridPane visible
        this.setGridLinesVisible(true);

        this.setPadding(new Insets(10));
        this.setHgap(5);
        this.setVgap(5);

        int ligne = 0;

        for(int x=0; x<10; x++){
            this.addColumn(x,new Label(" "));
            for(int y=0; y<10; y++){
                this.addRow(y,new Label(" "));
            }
        }
    }
}
