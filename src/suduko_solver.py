import time


def is_valid(board, row, col, num):
    # Check if num is not in the current row
    for x in range(9):
        if board[row][x] == num:
            return False

    # Check if num is not in the current column
    for x in range(9):
        if board[x][col] == num:
            return False

    # Check if num is not in the current 3x3 box
    start_row = row - row % 3
    start_col = col - col % 3
    for i in range(3):
        for j in range(3):
            if board[i + start_row][j + start_col] == num:
                return False
    return True


def solve_sudoku(board):
    empty = find_empty_location(board)
    if not empty:
        return True  # Puzzle solved
    row, col = empty

    for num in range(1, 10):
        if is_valid(board, row, col, num):
            board[row][col] = num
            if solve_sudoku(board):
                return True
            board[row][col] = 0  # Backtrack

    return False


def find_empty_location(board):
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] == 0:
                return (i, j)
    return None


# Example Sudoku puzzle
sudoku_board = [
    [0, 0, 0, 0, 1, 3, 0, 0, 0],
    [0, 0, 0, 6, 8, 0, 0, 0, 2],
    [0, 0, 6, 0, 0, 0, 0, 0, 0],
    [2, 0, 0, 4, 7, 0, 0, 0, 5],
    [4, 0, 0, 8, 0, 8, 0, 0, 0],
    [0, 0, 5, 0, 6, 0, 0, 3, 0],
    [0, 0, 0, 3, 0, 5, 0, 2, 6],
    [0, 0, 3, 0, 0, 0, 8, 0, 1],
    [0, 0, 0, 0, 8, 0, 4, 0, 0]
]

if __name__ == "__main__":
    current_time = time.time()
    if solve_sudoku(sudoku_board):
        print("Solution found:")
        for row in sudoku_board:
            print(row)
    else:
        print("No solution exists.")
    print("Total time: " + str((time.time() - current_time)))
