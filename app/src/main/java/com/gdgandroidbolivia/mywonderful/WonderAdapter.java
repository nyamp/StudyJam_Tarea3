package com.gdgandroidbolivia.mywonderful;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class WonderAdapter extends RecyclerView.Adapter<WonderAdapter.WonderViewHolder> {

    List<Wonder> dataset;
    Context context;
    onWonderSelectedListener onWonderSelectedListener;

    public interface  onWonderSelectedListener {
        void onWonderSelected (Wonder wonder);
    }

    public  WonderAdapter (Context context, onWonderSelectedListener onWonderSelectedListener){
        this.context = context;
        this.dataset = new ArrayList<>();
        this.onWonderSelectedListener = onWonderSelectedListener;
    // cada uno ponerlo en public exMarce: EquipoAdapter(Context context, onEquipoSelectedListener onEquipoSelectedListener)
    }
    @Override
    public WonderViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wonder,parent,false);
        //devolver la vista
        return new WonderViewHolder (view);
    }

    @Override
    public void onBindViewHolder (WonderViewHolder holder, int position) {
    //nos sirve para llenar los datos a nuestra clase
    //get wonders que estan en la lista
    Wonder wonder = dataset.get(position);
       // holder.nombre.setText(wonder.getNombre());
            //ExMarce: get nombre del equipo y lo mando al holder
            //ExMarce: get imagen del equipo y lo mando al holder
    holder.imagen.setImageResource (wonder.getImagen());
    holder.setOnWonderSelectedListener(wonder,onWonderSelectedListener );
        }
        @Override
    public int getItemCount () {
            return dataset.size();    }
             //devuelve el tamaño de la lista -size

    public class WonderViewHolder extends RecyclerView.ViewHolder {
        //crear vistas to use - ahora dentro del view holder enlazar las imagenes
        View cardView;
        ImageView imagen;
       // TextView nombre;

        public WonderViewHolder(View itemView){
            super(itemView);

            cardView = itemView.findViewById(R.id.card_main);
            imagen = itemView.findViewById(R.id.imagen_item);
         //   nombre = itemView.findViewById(R.id.texto_item);
        }

        public void setOnWonderSelectedListener (final Wonder wonder, final onWonderSelectedListener onWonderSelectedListener){
            cardView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                  onWonderSelectedListener.onWonderSelected(wonder);

                }
            });
        }
    }
        public void setDataSet (List<Wonder> wonders){
        if (wonders == null){
            dataset = new ArrayList<>();
        }
        else {
            dataset = wonders;
        }
        notifyDataSetChanged();
    }


}