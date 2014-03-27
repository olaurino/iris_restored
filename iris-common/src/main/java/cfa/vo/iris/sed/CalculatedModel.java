/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfa.vo.iris.sed;

/**
 *
 * @author omar
 */
public class CalculatedModel {
    private final double[] x;
    private final double[] y;
    private final double[] err;
    
    public CalculatedModel(double[] x, double[] y, double[] err) {
        this.x = x;
        this.y = y;
        this.err = err;
    }
    
    public double[] getX() {
        return this.x;
    }
    
    public double[] getY() {
        return this.y;
    }
    
    public double[] getErr() {
        return this.err;
    }
}
