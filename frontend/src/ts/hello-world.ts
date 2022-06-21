import { css, customElement,html, LitElement} from "lit";
import '@vaadin/button';
import '@vaadin/text-field'
import '@axa-ch/input-text';


class HelloWorld extends LitElement {


    render() {
        return html`
            	<div id="content"></div>
		<vaadin-text-field id="first-input" label="Your name"></vaadin-text-field>
                <vaadin-text-field id="second-input"></vaadin-text-field>
                <vaadin-button id="hello-button">Click me!</vaadin-button>`;
    }
}

customElements.define('hello-world', HelloWorld);
