//function solve(input) {
//    const output = [];
//    input.reduce((acc, curr) => {
//        if(acc !== undefined) {
//            output.push(acc)
//        }
//        if(curr >= output[output.length - 1]) {
//            output.push(curr)
//        }
//    })
//    return output;
//}

function solve(input) {
    const result = input.reduce((acc, curr) => {
        curr >= acc[acc.length - 1] || acc.length === 0 ? acc.push(curr) : '';
        return acc;
    }, []);
    return result;
}

console.log(solve(
    [1, 3, 8, 4, 10, 12, 3, 2, 24]
))

