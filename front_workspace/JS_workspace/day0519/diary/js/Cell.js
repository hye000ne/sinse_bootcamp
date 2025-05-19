class Cell {
    constructor(container, x, y, w, h, backgroundColor, borderColor, date) {
        /*============ Data ============*/
        this.year;
        this.month;
        this.date = date;
        this.icon;

        /*============ UI ============*/
        this.container = container;
        this.div = document.createElement("div");
        this.numDiv = document.createElement("div"); //날짜 영역
        this.titleDiv = document.createElement("div"); //제목 영역
        this.iconDiv = document.createElement("div"); //아이콘 영역
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;

        // cell div style
        this.div.style.position = "absolute";
        this.div.style.left = this.x + "px";
        this.div.style.top = this.y + "px";
        this.div.style.width = this.w + "px";
        this.div.style.height = this.h + "px";
        this.div.style.backgroundColor = this.backgroundColor;
        this.div.style.border = "1px solid " + this.borderColor;
        this.div.style.borderRadius = 10 + "px";
        this.div.style.boxSizing = "border-box"; //border, margin, padding에 의한 박스의 크기가 inside로 적용

        // num div style
        this.numDiv.style.width = 100 + "%";
        this.numDiv.style.height = 25 + "px";
        this.numDiv.style.textAlign = "right";
        this.numDiv.style.paddingRight = 5 + "px";
        this.numDiv.style.boxSizing = "border-box";

        // title div style
        this.titleDiv.style.width = 100 + "%";
        this.titleDiv.style.height = 25 + "px";

        // icon div style
        this.iconDiv.style.width = 100 + "%";
        this.iconDiv.style.height = 50 + "px";
        this.iconDiv.style.position = "absolute";

        this.div.appendChild(this.numDiv);
        this.div.appendChild(this.titleDiv);
        this.div.appendChild(this.iconDiv);

        this.container.appendChild(this.div);

        this.div.addEventListener("click", () => {
            openDialog(this);
        });
    }

    // 날짜 변경 메서드
    setDate(year, month, date) {
        this.year = year;
        this.month = month;
        this.date = date;

        this.numDiv.innerText = this.date;
    }

    renderIcon(src) {
        this.icon = document.createElement("img");
        this.icon.src = src;
        this.icon.style.width = 25 + "px";

        this.iconDiv.appendChild(this.icon);
    }
}
