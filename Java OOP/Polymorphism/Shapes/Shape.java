package Shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    protected abstract void calculatePerimeter();
    protected abstract void calculateArea();

    protected void setArea(Double area) {
        this.area = area;
    }

    protected void setPerimeter(Double perimeter) { //shtom sa s protected naslednicite shte sa zaduljenie da set-nat!
        this.perimeter = perimeter;
    }

    public Double getArea() {
        if (perimeter == null) {
            calculateArea();
        }
        return this.area;
    }

    public Double getPerimeter() {
        calculatePerimeter();
        return this.perimeter;
    }
}
