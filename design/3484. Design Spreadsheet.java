/**
 * @param {number} rows
 */
var Spreadsheet = function (rows) {
    this.cells = new Array(rows).fill().map(() => new Array(26).fill(0));

    this.getCol = (cell) => cell[0].charCodeAt(0) - 'A'.charCodeAt(0);
    this.getRow = (cell) => cell.slice(1, cell.length) - 1;
};

/** 
 * @param {string} cell 
 * @param {number} value
 * @return {void}
 */
Spreadsheet.prototype.setCell = function (cell, value) {
    const col = this.getCol(cell);
    const row = this.getRow(cell);

    this.cells[row][col] = Number(value);
};

/** 
 * @param {string} cell
 * @return {void}
 */
Spreadsheet.prototype.resetCell = function (cell) {
    const col = this.getCol(cell);
    const row = this.getRow(cell);

    this.cells[row][col] = 0;
};

/** 
 * @param {string} formula
 * @return {number}
 */
Spreadsheet.prototype.getValue = function (formula) {
    const [a, b] = formula.slice(1, formula.length).split('+');

    return (this.getCol(a) < 0 ? Number(a) : this.cells[this.getRow(a)][this.getCol(a)]) +
        (this.getCol(b) < 0 ? Number(b) : this.cells[this.getRow(b)][this.getCol(b)]);
};

/** 
 * Your Spreadsheet object will be instantiated and called as such:
 * var obj = new Spreadsheet(rows)
 * obj.setCell(cell,value)
 * obj.resetCell(cell)
 * var param_3 = obj.getValue(formula)
 */