const app = Vue.createApp({
    data() {
        return {
            logData: "",
            logNr: 1
        }
    },
    methods: {
        newLog(calculation) {
            this.logData += this.logNr + ": " + calculation + "\n";
            this.logNr += 1;
        }
    }
})