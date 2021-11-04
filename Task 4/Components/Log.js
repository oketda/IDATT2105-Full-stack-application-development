app.component('log', {
    props: {
        log: {
            type: String
        }
    },
    template: '<div class="log">\n' +
        '            <h1 class="loggerHeader">Log:</h1>\n' +
        '            <hr>\n' +
        '            <textarea class="loggerField" disabled>{{log}}</textarea>\n' +
        '        </div>',
    data() {
        return {
        }
    }
})