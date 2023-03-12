public class Block {
    public static final int[][] BLOCK_SHAPE_I = {{1, 1, 1, 1}};
    public static final int[][] BLOCK_SHAPE_J = {{1, 0, 0}, {1, 1, 1}};
    public static final int[][] BLOCK_SHAPE_L = {{0, 0, 1}, {1, 1, 1}};
    public static final int[][] BLOCK_SHAPE_O = {{1, 1}, {1, 1}};
    public static final int[][] BLOCK_SHAPE_S = {{0, 1, 1}, {1, 1, 0}};
    public static final int[][] BLOCK_SHAPE_T = {{0, 1, 0}, {1, 1, 1}};
    public static final int[][] BLOCK_SHAPE_Z = {{1, 1, 0}, {0, 1, 1}};

    public static final int[][][] BLOCK_SHAPES = {BLOCK_SHAPE_I, BLOCK_SHAPE_J, BLOCK_SHAPE_L, BLOCK_SHAPE_O,
                                                  BLOCK_SHAPE_S, BLOCK_SHAPE_T, BLOCK_SHAPE_Z};
    private int[][] blockShape; // 블록의 모양
    private int currentRotation; // 현재 회전된 상태
    private int row; // 블록이 현재 있는 행
    private int col; // 블록이 현재 있는 열

    // 블록의 모양과 시작 위치를 받아 초기화
    private Block getRandomBlock() {
        int rand = (int) (Math.random() * 7); // 0~6 사이의 랜덤한 정수 생성
        switch (rand) {
            case 0:
                return new Block(Block.BLOCK_SHAPE_I, 0, 0);
            case 1:
                return new Block(Block.BLOCK_SHAPE_J, 0, 0);
            case 2:
                return new Block(Block.BLOCK_SHAPE_L, 0, 0);
            case 3:
                return new Block(Block.BLOCK_SHAPE_O, 0, 0);
            case 4:
                return new Block(Block.BLOCK_SHAPE_S, 0, 0);
            case 5:
                return new Block(Block.BLOCK_SHAPE_T, 0, 0);
            default:
                return new Block(Block.BLOCK_SHAPE_Z, 0, 0);
        }
    }
    public Block(int[][] shape, int row, int col) {
        this.blockShape = shape;
        this.currentRotation = 0;
        this.row = row;
        this.col = col;
    }

    // 블록을 이동시킴
    public void move(int dRow, int dCol) {
        this.row += dRow;
        this.col += dCol;
    }

    // 블록을 시계방향으로 회전시킴
    public void rotateClockwise() {
        this.currentRotation = (this.currentRotation + 1) % 4;
    }

    // 블록을 반시계방향으로 회전시킴
    public void rotateCounterClockwise() {
        this.currentRotation = (this.currentRotation + 3) % 4;
    }

    // 블록의 모양을 반환함
    public int[][] getBlockShape() {
        return this.blockShape;
    }

    // 블록이 현재 있는 행을 반환함
    public int getRow() {
        return this.row;
    }

    // 블록이 현재 있는 열을 반환함
    public int getCol() {
        return this.col;
    }

    // 블록이 현재 회전된 상태를 반환함
    public int getCurrentRotation() {
        return this.currentRotation;
    }
}