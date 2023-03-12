public class Board {
	private int numRows; // 보드의 행 수
	private int numCols; // 보드의 열 수
	private int[][] boardState; // 보드의 상태
	private Block currentBlock; // 현재 떨어지고 있는 블록

	// 보드의 크기를 받아 초기화
	public Board(int numRows, int numCols) {
		this.numRows = numRows;
		this.numCols = numCols;
		this.boardState = new int[numRows][numCols];
		this.currentBlock = null;
	}

	// 블록을 새로 생성하고 떨어뜨림
	public boolean spawnBlock(Block block) {
		// 보드의 중앙 위쪽에서 블록이 떨어지도록 위치 설정
		int col = (this.numCols - block.getBlockShape().length) / 2;
		this.currentBlock = new Block(block.getBlockShape(), 0, col);
		return isValidPosition(this.currentBlock);
	}

	// 블록을 이동시키고 블록이 바닥에 도착하면 블록을 고정시키고 새로운 블록 생성
	public boolean moveBlock(int dRow, int dCol) {
		if (this.currentBlock == null) {
			return false;
		}

		Block newBlock = new Block(this.currentBlock.getBlockShape(), this.currentBlock.getRow() + dRow,
				this.currentBlock.getCol() + dCol);

		if (isValidPosition(newBlock)) {
			this.currentBlock = newBlock;
			return true;
		} else if (dRow != 0) { // 블록이 바닥에 도달한 경우
			fixBlock(); // 블록을 고정시키고
			return spawnBlock(getRandomBlock()); // 새로운 블록 생성
		} else {
			return false;
		}
	}

	// 블록을 고정시킴
	private void fixBlock() {
		int[][] blockShape = this.currentBlock.getBlockShape();
		int row = this.currentBlock.getRow();
		int col = this.currentBlock.getCol();

		// 보드에 블록을 추가함
		for (int i = 0; i < blockShape.length; i++) {
			for (int j = 0; j < blockShape[i].length; j++) {
				if (blockShape[i][j] == 1) {
					this.boardState[row + i][col + j] = 1;
				}
			}
		}

		this.currentBlock = null;
	}

	// 보드의 상태를 반환함
	public int[][] getBoardState() {
		return this.boardState;
	}

	// 블록이 유효한 위치인지 확인함
	private boolean isValidPosition(Block block) {
		int[][] blockShape = block.getBlockShape();
		int row = block.getRow();
		int col = block.getCol();

		// 보드 범위를 벗어나는 경우
		if (row < 0 || row + blockShape.length > this.numRows || col < 0 || col + blockShape[0].length > this.numCols) {
			return false;
		}

		// 다른 블록과충돌하는 경우
		for (int i = 0; i < blockShape.length; i++) {
			for (int j = 0; j < blockShape[i].length; j++) {
				if (blockShape[i][j] == 1) {
					int r = row + i;
					int c = col + j;
					if (r >= 0 && r < this.numRows && c >= 0 && c < this.numCols && this.boardState[r][c] == 1) {
						return false;
					}
				}
			}
		}
		return true;
	}

	// 랜덤한 블록을 생성함
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
}