package cinefeel.romain.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

class MyAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private List<String> users;

    public MyAdapter(List<String> users){
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_view_list, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder myViewHolder, int i) {
        myViewHolder.updateWithUser(this.users.get(i));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
