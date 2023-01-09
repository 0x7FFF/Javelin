package com.smakhorin.easycodeandroidtask.core;

import android.view.View;

import androidx.annotation.NonNull;

public interface Visibility {

    void apply(View view);

    abstract class Abstract implements Visibility {
        Integer visibility;

        public Abstract(@NonNull Integer visibility) {
            this.visibility = visibility;
        }

        @Override
        public void apply(View view) {
            view.setVisibility(visibility);
        }
    }

    class Visible extends Abstract {
        public Visible(@NonNull Integer visibility) {
            super(visibility);
        }

        public Visible() {
            this(View.VISIBLE);
        }
    }

    class Gone extends Abstract {
        public Gone(@NonNull Integer visibility) {
            super(visibility);
        }

        public Gone() {
            this(View.GONE);
        }
    }


    class Invisible extends Abstract {
        public Invisible(@NonNull Integer visibility) {
            super(visibility);
        }

        public Invisible() {
            this(View.INVISIBLE);
        }
    }
}
