class HP {
    constructor(container, x, y) {
        this.container = container;
        this.span = document.createElement('span');
        this.x = x;
        this.y = y;

        this.span.style.position = 'absolute';
        this.span.style.left = this.x + 'px';
        this.span.style.top = this.y + 'px';
        this.span.innerText = '❤️';
        this.span.style.fontSize = '40px';

        this.container.appendChild(this.span);
    }

    // DOM에서 제거
    destroy() {
        this.container.removeChild(this.span);
    }
}
