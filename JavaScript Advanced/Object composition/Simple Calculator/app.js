function solve() {
    const data = {};
    const calc = {
        init: (selector1, selector2, resultSelector) => {
            data.firstElement = document.querySelector(selector1);
            data.secondElement = document.querySelector(selector2);
            data.resultElement = document.querySelector(resultSelector);
        },
        add: () =>
            data.resultElement.value = Number(data.firstElement.value) + Number(data.secondElement.value),
        subtract: () => data.resultElement.value = Number(data.firstElement.value) - Number(data.secondElement.value),
        multiplication: () => data.resultElement.value = Number(data.firstElement.value) * Number(data.secondElement.value),
        division: () => data.resultElement.value = Number(data.firstElement.value) / Number(data.secondElement.value),
        clear: () => {
                data.firstElement.value = null,
                data.secondElement.value = null,
                data.resultElement.value = null
        }
    }
    calc.init('#num1', '#num2', '#result');
    const sumBtn = document.querySelector('#sumButton');
    const subtractBtn = document.querySelector('#subtractButton');
    const mltBtn = document.querySelector('#multiplicationButton');
    const divisionBtn = document.querySelector('#divisionButton');
    const clearBtn = document.querySelector('#clearButton');
    sumBtn.addEventListener('click', calc.add);
    subtractBtn.addEventListener('click', calc.subtract);
    mltBtn.addEventListener('click', calc.multiplication);
    divisionBtn.addEventListener('click', calc.division);
    clearBtn.addEventListener('click', calc.clear);
}