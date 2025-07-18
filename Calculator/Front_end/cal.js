function append(val) {
    document.getElementById('display').value += val;
  }
  
  function clearDisplay() {
    document.getElementById('display').value = '';
  }
  
  function calculate() {
    const input = document.getElementById('display').value;
    try {
      const result = customEval(input);
      document.getElementById('display').value = result;
    } catch (e) {
      document.getElementById('display').value = 'Error';
    }
  }
  
  // Custom eval parser
  function customEval(expr) {
    // Basic example: manually replace functions with custom ones
    expr = expr.replace(/sin\(([^)]+)\)/g, (_, angle) => sin(parseFloat(angle)));
    expr = expr.replace(/cos\(([^)]+)\)/g, (_, angle) => cos(parseFloat(angle)));
    expr = expr.replace(/tan\(([^)]+)\)/g, (_, angle) => tan(parseFloat(angle)));
  
    // Warning: eval used here temporarily — we’ll replace this with a safe parser later
    return eval(expr); 
  }
  
  // Taylor Series Approximations
  function factorial(n) {
    let res = 1;
    for (let i = 2; i <= n; i++) res *= i;
    return res;
  }
  
  function sin(x) {
    x = x * Math.PI / 180; // convert to radians
    let res = 0;
    for (let i = 0; i < 10; i++) {
      res += ((i % 2 === 0 ? 1 : -1) * Math.pow(x, 2 * i + 1)) / factorial(2 * i + 1);
    }
    return res;
  }
  
  function cos(x) {
    x = x * Math.PI / 180;
    let res = 0;
    for (let i = 0; i < 10; i++) {
      res += ((i % 2 === 0 ? 1 : -1) * Math.pow(x, 2 * i)) / factorial(2 * i);
    }
    return res;
  }
  
  function tan(x) {
    return sin(x) / cos(x);
  }
  