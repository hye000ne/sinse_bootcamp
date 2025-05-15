class Word {
    constructor(container, x, y, text) {
        this.container = container;
        this.span = document.createElement('span');
        this.x = x;
        this.y = y;
        this.text = text;

        this.span.style.position = 'absolute';
        this.span.style.left = this.x + 'px';
        this.span.style.top = this.y + 'px';
        this.span.innerText = this.text;
        this.span.style.fontSize = '20px';
        this.span.style.color = '#333';

        this.container.appendChild(this.span);
    }

    move(speed) {
        this.y += speed;
        this.span.style.top = this.y + 'px';
    }

    // DOM에서 제거
    destroy() {
        this.container.removeChild(this.span);
    }
}
