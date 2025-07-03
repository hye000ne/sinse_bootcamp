class Cell {
    constructor(container, width, height, bg, border, bdColor, num) {
        this.container = container;
        this.div = document.createElement("div");
        this.width = width;
        this.height = height;
        this.bg = bg;
        this.border = border;
        this.bdColor = bdColor;
        this.num = num;

        this.div.style.width = this.width + "px";
        this.div.style.height = this.height + "px";
        this.div.style.backgroundColor = this.bg;
        this.div.style.border = `${this.border}px solid ${this.bdColor}`;
        this.div.style.display = "inline-block";
        this.div.innerText = this.num;

        this.container.appendChild(this.div);
    }
}
