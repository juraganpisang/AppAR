package juragan.pisang;


import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    ArFragment arFragment;
    private ModelRenderable bearRenderable,
            catRenderable,
            cowRenderable,
            dogRenderable,
            elephantRenderable,
            ferretRenderable,
            hippoRenderable,
            horseRenderable,
            koalaRenderable,
            lionRenderable,
            reindeerRenderable,
            wolverineRenderable;

    ImageView bear, cat, cow, dog, elephant, ferret, hippo, horse, koala, lion, reindeer, wolverine;

    View arrayView[];
//    ViewRenderable name_animal;

    int selected = 1; // default is bear

//    ViewRenderable nama_hewan;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Home");

        arFragment = (ArFragment) getFragmentManager().findFragmentById(R.id.sceneform_ux_fragment);

        //view
        bear = view.findViewById(R.id.bear);
        cat = view.findViewById(R.id.cat);
        cow = view.findViewById(R.id.cow);
        dog = view.findViewById(R.id.dog);
        elephant = view.findViewById(R.id.elephant);
        ferret = view.findViewById(R.id.ferret);
        hippo = view.findViewById(R.id.hippo);
        horse = view.findViewById(R.id.horse);
        koala = view.findViewById(R.id.koala);
        lion = view.findViewById(R.id.lion);
        reindeer = view.findViewById(R.id.reindeer);
        wolverine = view.findViewById(R.id.wolverine);

        setArrayView();
        setOnclickListener();

        setupModel();

        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                //when user tap on plane, we will add model

                Anchor anchor = hitResult.createAnchor();
                AnchorNode anchorNode = new AnchorNode(anchor);
                anchorNode.setParent(arFragment.getArSceneView().getScene());

                createModel(anchorNode, selected);

            }
        });
    }

    private void setupModel() {

//        ViewRenderable.builder()
//                .setView(getContext(), R.layout.nama_hewan)
//                .build()
//                .thenAccept(renderable -> nama_hewan = renderable);

        ModelRenderable.builder()
                .setSource(getContext(), R.raw.bear)
                .build().thenAccept(renderable -> bearRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast = Toast.makeText(getContext(), "Tidak dapat memproses model Beruang", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(getContext(), R.raw.cat)
                .build().thenAccept(renderable -> catRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast = Toast.makeText(getContext(), "Tidak dapat memproses model Kucing", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;
                        }
                );


        ModelRenderable.builder()
                .setSource(getContext(), R.raw.cat)
                .build().thenAccept(renderable -> catRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast = Toast.makeText(getContext(), "Tidak dapat memproses model Kucing", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;
                        }
                );


        ModelRenderable.builder()
                .setSource(getContext(), R.raw.cow)
                .build().thenAccept(renderable -> cowRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast = Toast.makeText(getContext(), "Tidak dapat memproses model Sapi", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;
                        }
                );


        ModelRenderable.builder()
                .setSource(getContext(), R.raw.dog)
                .build().thenAccept(renderable -> dogRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast = Toast.makeText(getContext(), "Tidak dapat memproses model Anjing", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;
                        }
                );


        ModelRenderable.builder()
                .setSource(getContext(), R.raw.ferret)
                .build().thenAccept(renderable -> ferretRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast = Toast.makeText(getContext(), "Tidak dapat memproses model Berang-Berang", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;
                        }
                );


        ModelRenderable.builder()
                .setSource(getContext(), R.raw.hippopotamus)
                .build().thenAccept(renderable -> hippoRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast = Toast.makeText(getContext(), "Tidak dapat memproses model Kudanil", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(getContext(), R.raw.horse)
                .build().thenAccept(renderable -> horseRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast = Toast.makeText(getContext(), "Tidak dapat memproses model Kuda", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(getContext(), R.raw.koala_bear)
                .build().thenAccept(renderable -> koalaRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast = Toast.makeText(getContext(), "Tidak dapat memproses model Koala", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(getContext(), R.raw.lion)
                .build().thenAccept(renderable -> lionRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast = Toast.makeText(getContext(), "Tidak dapat memproses model Singa", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(getContext(), R.raw.reindeer)
                .build().thenAccept(renderable -> reindeerRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast = Toast.makeText(getContext(), "Tidak dapat memproses model Rusa", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(getContext(), R.raw.wolverine)
                .build().thenAccept(renderable -> wolverineRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast = Toast.makeText(getContext(), "Tidak dapat memproses model Wolverine", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;
                        }
                );
    }

    private void createModel(AnchorNode anchorNode, int selected) {

        if (selected == 1) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(bearRenderable);
            bear.select();

            addName(anchorNode, bear, "Beruang");
        }
        if (selected == 2) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(catRenderable);
            bear.select();

            addName(anchorNode, bear, "Kucing");
        }
        if (selected == 3) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(cowRenderable);
            bear.select();

            addName(anchorNode, bear, "Sapi");
        }
        if (selected == 4) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(dogRenderable);
            bear.select();

            addName(anchorNode, bear, "Anjing");
        }
        if (selected == 5) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(elephantRenderable);
            bear.select();

            addName(anchorNode, bear, "Gajah");
        }
        if (selected == 6) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(ferretRenderable);
            bear.select();

            addName(anchorNode, bear, "Berang-Berang");
        }
        if (selected == 7) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(hippoRenderable);
            bear.select();

            addName(anchorNode, bear, "Kudanil");
        }
        if (selected == 8) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(horseRenderable);
            bear.select();

            addName(anchorNode, bear, "Kuda");
        }
        if (selected == 9) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(koalaRenderable);
            bear.select();

            addName(anchorNode, bear, "Koala");
        }
        if (selected == 10) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(cowRenderable);
            bear.select();

            addName(anchorNode, bear, "Singa");
        }
        if (selected == 11) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(reindeerRenderable);
            bear.select();

            addName(anchorNode, bear, "Rusa");
        }
        if (selected == 12) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(wolverineRenderable);
            bear.select();

            addName(anchorNode, bear, "Wolverine");
        }
    }

    private void addName(AnchorNode anchorNode, TransformableNode model, String name) {

        //each model we will create each name
        ViewRenderable.builder().setView(getContext(), R.layout.nama_hewan)
                .build()
                .thenAccept(viewRenderable -> {
                    TransformableNode nameView = new TransformableNode(arFragment.getTransformationSystem());
                    nameView.setLocalPosition(new Vector3(0f, model.getLocalPosition().y + 0.5f, 0));
                    nameView.setParent(anchorNode);
                    nameView.setRenderable(viewRenderable);
                    nameView.select();

                    //set text
                    TextView txt_name = (TextView) viewRenderable.getView();
                    txt_name.setText(name);

                    //click to text view to remove animal
                    txt_name.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            anchorNode.setParent(null);
                        }
                    });
                });
    }

    private void setOnclickListener() {
        for (int i = 0; i < arrayView.length; i++) {
            arrayView[i].setOnClickListener(this);
        }
    }

    private void setArrayView() {
        arrayView = new View[]{
                bear, cat, cow, dog, elephant, ferret, hippo, horse, koala, lion, reindeer, wolverine
        };
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bear) {
            selected = 1;
            setBackground(v.getId());
        } else if (v.getId() == R.id.cat) {
            selected = 2;
            setBackground(v.getId());
        } else if (v.getId() == R.id.cow) {
            selected = 3;
            setBackground(v.getId());
        } else if (v.getId() == R.id.dog) {
            selected = 4;
            setBackground(v.getId());
        } else if (v.getId() == R.id.elephant) {
            selected = 5;
            setBackground(v.getId());
        } else if (v.getId() == R.id.ferret) {
            selected = 6;
            setBackground(v.getId());
        } else if (v.getId() == R.id.hippo) {
            selected = 7;
            setBackground(v.getId());
        } else if (v.getId() == R.id.horse) {
            selected = 8;
            setBackground(v.getId());
        } else if (v.getId() == R.id.koala) {
            selected = 9;
            setBackground(v.getId());
        } else if (v.getId() == R.id.lion) {
            selected = 10;
            setBackground(v.getId());
        } else if (v.getId() == R.id.reindeer) {
            selected = 11;
            setBackground(v.getId());
        } else if (v.getId() == R.id.wolverine) {
            selected = 12;
            setBackground(v.getId());
        }
    }

    private void setBackground(int id) {
        for (int i = 0; i < arrayView.length; i++) {
            if (arrayView[i].getId() == id) {
                arrayView[i].setBackgroundColor(Color.parseColor("#80333639"));
            } else {
                arrayView[i].setBackgroundColor(Color.TRANSPARENT);
            }
        }
    }
}
