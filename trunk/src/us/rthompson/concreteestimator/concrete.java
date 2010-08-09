package us.rthompson.concreteestimator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class concrete extends Activity implements OnClickListener {
	
	private EditText lengthft;
	private EditText lengthin;
	private EditText widthft;
	private EditText widthin;
	private EditText thickness;
	private Button calc;
	private TextView amount;
	private TextView bags;
	private TextView sand;
	private TextView gravel;
		
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    lengthft = (EditText)this.findViewById(R.id.lengthft);
    lengthin = (EditText)this.findViewById(R.id.lengthin);
    widthft = (EditText)this.findViewById(R.id.widthft);
    widthin = (EditText)this.findViewById(R.id.widthin);
    thickness = (EditText)this.findViewById(R.id.thickness);
    calc = (Button)this.findViewById(R.id.calc);
    amount = (TextView)this.findViewById(R.id.amount);
    bags = (TextView)this.findViewById(R.id.bags);
    sand = (TextView)this.findViewById(R.id.sand);
    gravel = (TextView)this.findViewById(R.id.gravel);
    calc.setOnClickListener(this);
    }

	public void onClick(View v) {
		// convert sizes to inches
		double length = Double.parseDouble(lengthft.getText().toString());
		length = length * 12;
		length = length + Double.parseDouble(lengthin.getText().toString());
		double width = Double.parseDouble(widthft.getText().toString());
		width = width * 12;
		width = width + Double.parseDouble(widthin.getText().toString());
		double thick = Double.parseDouble(thickness.getText().toString());
				
		amount.setText(Double.toString(round2(length * width * thick / 46656))+" Yards of Concrete");
		bags.setText(Double.toString(round2(length * width * thick / 8483))+" bags");
		sand.setText(Integer.toString((int) (length * width * thick / 29.9))+"lbs or "+Double.toString(round2(length * width * thick / 2745))+" Cubic Ft");
		gravel.setText(Integer.toString((int) (length * width * thick / 29))+"lbs or "+Double.toString(round2(length * width * thick / 2592))+" Cubic Ft");
	}
    
	public static double round2(double num) {
		int temp=(int)((num*Math.pow(10,1)));
		return (((double)temp)/Math.pow(10,1));
		}
	




}