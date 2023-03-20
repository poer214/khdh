const game = {
	board: [],
	player: 1,
	winner: null
};

// 게임판 요소와 셀 요소들을 선택합니다.
const boardEl = document.querySelector('.board');
const cellEls = [];

// 게임판을 초기화합니다.
for (let i = 0; i < 15; i++) {
	game.board[i] = [];
	for (let j = 0; j < 15; j++) {
		game.board[i][j] = 0;
		const cellEl = document.createElement('div');
		cellEl.classList.add('cell');
		cellEl.addEventListener('click', () => {
			if (!game.winner && game.board[i][j] === 0) {
				game.board[i][j] = game.player;
				cellEl.classList.add(game.player === 1 ? 'black' : 'white');
				checkWinner();
				game.player = game.player === 1 ? 2 : 1;
			}
		});
		boardEl.appendChild(cellEl);
		cellEls.push(cellEl);
	}
}

// 승자가 있는지 체크합니다.
function checkWinner() {
	// 가로 체크
	for (let i = 0; i < 15; i++) {
		for (let j = 0; j < 11; j++) {
			if (game.board[i][j] === game.player &&
				game.board[i][j + 1] === game.player &&
				game.board[i][j + 2] === game.player &&
				game.board[i][j + 3] === game.player &&
				game.board[i][j + 4] === game.player) {
				game.winner = game.player;
				return;
			}
		}
	}

	// 세로 체크
	for (let i = 0; i < 11; i++) {
		for (let j = 0; j < 15; j++)
			if (game.board[i][j] === game.player &&
				game.board[i + 1][j] === game.player &&
				game.board[i + 2][j] === game.player &&
				game.board[i + 3][j] === game.player &&
				game.board[i + 4][j] === game.player) {
				game.winner = game.player;
				return;
			}
	}


	// 대각선 체크 (좌상단 -> 우하단)
	for (let i = 0; i < 11; i++) {
		for (let j = 0; j < 11; j++) {
			if (game.board[i][j] === game.player &&
				i + 4 < 11 && j + 4 < 11 &&
				game.board[i + 1][j + 1] === game.player &&
				game.board[i + 2][j + 2] === game.player &&
				game.board[i + 3][j + 3] === game.player &&
				game.board[i + 4][j + 4] === game.player) {
				game.winner = game.player;
				return;
			}
		}
	}

	// 대각선 체크 (좌하단 -> 우상단)
	for (let i = 4; i < 15; i++) {
		for (let j = 0; j < 11; j++) {
			if (game.board[i][j] === game.player &&
				game.board[i - 1][j + 1] === game.player &&
				game.board[i - 2][j + 2] === game.player &&
				game.board[i - 3][j + 3] === game.player &&
				game.board[i - 4][j + 4] === game.player) {
				game.winner = game.player;
				return;
			}
		}
	}


	// 게임 초기화 함수
	function resetGame() {
		game.player = 1;
		game.winner = null;
		game.board = game.board.map(row => row.map(cell => 0));
		cellEls.forEach(cellEl => {
			cellEl.classList.remove('black', 'white');
		});
	}

	// 초기화 버튼 클릭 시 게임 초기화 함수를 호출합니다.
	const resetBtn = document.querySelector('#reset-btn');
	resetBtn.addEventListener('click', () => {
		resetGame();
	});
}