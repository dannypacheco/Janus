/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pieces;

import janus.Janus;

/**
 *
 * @author Ismael
 */
public class Bishop extends Piece {
    
    public Bishop(boolean white) {
        this.white = white;
    }
    
    @Override
    public void refreshValidMoves() {
        clearValids();
        int x = getPosition().getX();
        int y = getPosition().getY();
        int alpha = -1;
        int beta = -1;
        for(int i = 1; i <= 4; i++){
            for(int j = 1; j <= 7; j++){
                if(!isOutOfBounds(x + j * alpha, y + j * beta)){
                    Piece checkedPos = Janus.fetchPiece(x + j * alpha, y + j * beta);
                    if(checkedPos == null){
                        addValidMove(Janus.fetchPosition(x + j * alpha, y + j * beta));
                    }else{
                        if(checkedPos.isWhite() != white){
                            addValidMove(Janus.fetchPosition(x + j * alpha, y + j * beta));
                        }
                        break;
                    }
                }else{
                    break;
                }
            }
            beta *= -1;
            if(beta == -1){
                alpha = 1;
            }
            /* +-------+------+
             * | alpha | beta |
             * +-------+------+
             * |    -1 |   -1 |
             * |    -1 |    1 |
             * |     1 |   -1 |
             * |     1 |    1 |
             * +-------+------+
             */
        }
    }

    @Override
    public void refreshThreats() {
        clearThreats();
        int x = getPosition().getX();
        int y = getPosition().getY();
        int alpha = -1;
        int beta = -1;
        for(int i = 1; i <= 4; i++){
            for(int j = 1; j <= 7; j++){
                if(!isOutOfBounds(x + j * alpha, y + j * beta)){
                    Piece checkedPos = Janus.fetchPiece(x + j * alpha, y + j * beta);
                    if(checkedPos == null){
                        addThreat(Janus.fetchPosition(x + j * alpha, y + j * beta));
                    }else{
                        addThreat(Janus.fetchPosition(x + j * alpha, y + j * beta));
                        break;
                    }
                }else{
                    break;
                }
            }
            beta *= -1;
            if(beta == -1){
                alpha = 1;
            }
            /* +-------+------+
             * | alpha | beta |
             * +-------+------+
             * |    -1 |   -1 |
             * |    -1 |    1 |
             * |     1 |   -1 |
             * |     1 |    1 |
             * +-------+------+
             */
        }
    }
    
}
