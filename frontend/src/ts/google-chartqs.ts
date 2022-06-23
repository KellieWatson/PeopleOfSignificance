import { css, html, LitElement} from "lit";
import '@vaadin/button';
import '@vaadin/text-field'




class GoogleChartQS extends LitElement {
    render() {
        return html`
            <div id="content"></div>
            <div id="chart-div"></div>`;
    }
}
customElements.define('google-chartqs', GoogleChartQS);
