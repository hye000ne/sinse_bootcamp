class Word {
    constructor(container, x, y, content, color) {
        this.container = container;
        this.span = document.createElement("span");
        this.x = x;
        this.y = y;
        this.content = content;
        this.color = color;

        this.span.style.display = "inline-block";
        this.span.style.position = "absolute";
        this.span.style.left = this.x + "px";
        this.span.style.top = this.y + "px";
        this.span.style.color = this.color;
        this.span.innerText = this.content;

        this.container.appendChild(this.span);
    }

    //물리량 변화
    tick() {
        this.y += 15;
    }

    // 그래픽 처리
    render() {
        this.span.style.top = this.y + "px";
    }
}
