public class Tetromino {
    private int[][] coords;
    private BlockType blockType;

    public Tetromino(BlockType blockType) {
        this.blockType = blockType;
        coords = new int[4][2];
        setShape();
    }

    public enum BlockType {
        I, J, L, O, S, T, Z
    }

    private void setShape() {
        int[][][] shapes = new int[][][] {
            { { 0, 1 }, { 0, 2 }, { 0, 3 }, }, // I block
            { { 0, 1 }, { 1, 1 }, { 1, 0 }, }, // J block
            { { 0, 1 }, { 1, 1 }, { 1, 2 }, }, // L block
            { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } }, // O block
            { { 0, 1 }, { 1, 0 }, { 1, 1 }, { 2, 0 } }, // S block
            { { 0, 1 }, { 1, 0 }, { 1, 1 }, { 1, 2 } }, // T block
            { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 1 } } // Z block
        };
        int[][] shape = shapes[blockType.ordinal()];
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                coords[i][j] = shape[i][j];
            }
        }
    }

    public BlockType getBlockType() {
        return blockType;
    }

    public int[][] getCoords() {
        return coords;
    }
}
