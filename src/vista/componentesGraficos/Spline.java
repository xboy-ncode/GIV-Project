package vista.componentesGraficos;

import java.util.ArrayList;
import java.util.List;

public class Spline {

    public SplinePoint[] copyPoints() {
        SplinePoint[] ps = new SplinePoint[points.length];
        for (int i = 0; i < ps.length; i++) {
            ps[i] = new SplinePoint(points[i].getX(), points[i].getY());
        }
        return ps;
    }

    public SplinePoint[] getPoints() {
        return points;
    }

    public void setPoints(SplinePoint[] points) {
        this.points = points;
    }

    private SplinePoint[] points;

    public Spline() {
    }

    public List<SplinePoint> createSpline(float f, SplinePoint... point) {
        this.points = point;
        List<SplinePoint> list = new ArrayList<>();
        for (float t = 0f; t < (float) (point.length - 3.0f) * f; t += 0.01f) {
            list.add(getSpline(t));
        }
        return list;
    }

public SplinePoint getSpline(float t) {
    // Verifica si hay suficientes puntos
    if (points.length < 4) {
        throw new IndexOutOfBoundsException("Se requieren al menos 4 puntos para calcular el spline, pero se encontraron " + points.length);
    }

    int p1 = (int) t + 1;
    int p0 = p1 - 1;
    int p2 = p1 + 1;
    int p3 = p2 + 1;

    // Asegúrate de que los índices son válidos
    if (p0 < 0 || p3 >= points.length) {
        throw new IndexOutOfBoundsException("Índice fuera de límites en getSpline: p0 = " + p0 + ", p1 = " + p1 + ", p2 = " + p2 + ", p3 = " + p3);
    }

    // Verifica si los puntos son null
    if (points[p0] == null || points[p1] == null || points[p2] == null || points[p3] == null) {
        throw new NullPointerException("Uno de los puntos es null en getSpline: p0 = " + p0 + ", p1 = " + p1 + ", p2 = " + p2 + ", p3 = " + p3);
    }

    t = t - (int) t;
    float tt = t * t;
    float ttt = tt * t;
    float q1 = -ttt + 2.0f * tt - t;
    float q2 = 3.0f * ttt - 5.0f * tt + 2.0f;
    float q3 = -3.0f * ttt + 4.0f * tt + t;
    float q4 = ttt - tt;

    double tx = 0.5f * (points[p0].getX() * q1 + points[p1].getX() * q2 + points[p2].getX() * q3 + points[p3].getX() * q4);
    double ty = 0.5f * (points[p0].getY() * q1 + points[p1].getY() * q2 + points[p2].getY() * q3 + points[p3].getY() * q4);
    return new SplinePoint(tx, ty);
}


}
