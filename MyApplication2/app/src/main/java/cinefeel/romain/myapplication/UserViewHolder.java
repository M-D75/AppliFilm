package cinefeel.romain.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class UserViewHolder extends RecyclerView.ViewHolder {

    TextView textView;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        this.textView = itemView.findViewById(R.id.text1);
    }

    public void updateWithUser(String userName){
        this.textView.setText(userName);
    }
}
