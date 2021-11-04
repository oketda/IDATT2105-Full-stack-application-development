app.component('calculator', {
    template:
    /*html*/
        '<div class="calculator">\n' +
        '            <textarea class="calculator-screen" disabled>{{screenValue}}</textarea>\n' +
        '            <div class="calculator-numbers">\n' +
        '                <div class="789">\n' +
        '                    <button type="button" @click="numberPressed(7)">7</button>\n' +
        '                    <button type="button" @click="numberPressed(8)">8</button>\n' +
        '                    <button type="button" @click="numberPressed(9)">9</button>\n' +
        '                </div>\n' +
        '\n' +
        '                <div class="456">\n' +
        '                    <button type="button" @click="numberPressed(4)">4</button>\n' +
        '                    <button type="button" @click="numberPressed(5)">5</button>\n' +
        '                    <button type="button" @click="numberPressed(6)">6</button>\n' +
        '                </div>\n' +
        '\n' +
        '                <div class="123">\n' +
        '                    <button type="button" @click="numberPressed(1)">1</button>\n' +
        '                    <button type="button" @click="numberPressed(2)">2</button>\n' +
        '                    <button type="button" @click="numberPressed(3)">3</button>\n' +
        '                </div>\n' +
        '\n' +
        '                <div class="0">\n' +
        '                    <button type="button" @click="numberPressed(0)">0</button>\n' +
        '                    <button type="button" @click="commaPressed()">.</button>\n' +
        '                    <button type="button" class="ac" @click="acPressed()">AC</button>\n' +
        '                </div>\n' +
        '            </div>\n' +
        '            <div class="operators">\n' +
        '                <button type="button" @click="operatorPressed(operators[0])">+</button>\n' +
        '                <button type="button" @click="operatorPressed(operators[1])">-</button>\n' +
        '                <button type="button" @click="operatorPressed(operators[2])">*</button>\n' +
        '                <button type="button" @click="operatorPressed(operators[3])">/</button>\n' +
        '            </div>\n' +
        '            <div class="equals">\n' +
        '                <button type="button" class="equals-button" @click="calculate()">=</button>\n' +
        '            </div>\n' +
        '        </div>',
    data() {
            return {
                screenValue: '',
                calculation: '',
                operator: false,
                equals: false,
                operators: ['+', '-', '*', '/']
            }
    },
    methods: {
            numberPressed(value) {
                if (this.equals === true){
                    this.acPressed();
                    this.equals = false;
                }
                if (this.screenValue.length < 8 && this.operator === false){
                    this.screenValue += value;
                    this.calculation += value;
                }else if (this.operator === true){
                    this.operator = false;
                    this.screenValue = "";
                    this.screenValue += value;
                    this.calculation += value;
                }
            },
        commaPressed() {
                if (this.screenValue.length < 7 && this.screenValue.length > 0
                    && !this.calculation.endsWith(".") && this.operator === false){
                    this.screenValue += ".";
                    this.calculation += ".";
                }
                else if (this.screenValue.length === 0 || this.operator === true) {
                    this.screenValue = "0.";
                    this.calculation += "0.";
                    this.equals = false;
                    this.operator = false;
                }
        },
        acPressed() {
                this.screenValue = "";
                this.calculation = "";
                this.operator = false;
        },
        operatorPressed(operator) {
                if (this.screenValue.length > 0 && this.equals === false) {
                    this.screenValue = eval(this.calculation);
                    this.screenValue = this.screenValue.toString();

                    if (this.screenValue.length > 7){
                        let offset = this.screenValue.length-8;
                        this.screenValue = this.screenValue.slice(0, -offset);
                    }

                    this.calculation += operator;
                    this.operator = true;
                } else if(this.equals === true){
                    this.equals = false;
                    this.calculation += operator;
                    this.operator = true;
                }
        },
        calculate() {
                if (this.calculation.endsWith("+") || this.calculation.endsWith("-")
                 || this.calculation.endsWith("*") || this.calculation.endsWith("/")){
                    this.calculation = this.calculation.slice(0, -1);
                }
                let answer = eval(this.calculation);

                answer = answer.toString();

                if (answer.length > 7){
                    let offset = answer.length-8;
                    let approxAnswer = answer.slice(0, -offset);
                    this.screenValue = approxAnswer;
                }
                else {
                    this.screenValue = answer;
                }

                this.logCalculation(this.calculation + " = " + answer);
                this.calculation = answer;
                this.equals = true;
                this.operator = false;
        },
        logCalculation(calculation){
                this.$emit('log-calculation', calculation);
        }
    }
})