import { css, html, LitElement} from "lit";
import '@vaadin/button';
import '@vaadin/text-field'
import '@google-web-components/google-chart';



class GoogleChartQS extends LitElement {
    render() {
        return html`
            	<div id="content"></div>
                <google-chart data='[["Month", "Days"], ["Jan", 31]]'></google-chart>
		<vaadin-text-field id="first-input" label="Your name"></vaadin-text-field>
                <vaadin-text-field id="second-input"></vaadin-text-field>
                <vaadin-button id="hello-button">GoogleChartQS!</vaadin-button>`;
    }
}
customElements.define('google-chartqs', GoogleChartQS);
