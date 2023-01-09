package com.smakhorin.easycodeandroidtask.main.data;

import com.smakhorin.easycodeandroidtask.core.Supplier;
import com.smakhorin.easycodeandroidtask.core.data.HandleError;

public interface DataSource {
    <T> T handle(Supplier<T> ret) throws Exception;

    abstract class Abstract implements DataSource {

        private final HandleError handleError;

        protected Abstract(HandleError handleError) {
            this.handleError = handleError;
        }

        @Override
        public <T> T handle(Supplier<T> ret) throws Exception {
            try {
                return ret.get();
            } catch (Exception ex) {
                throw handleError.handle(ex);
            }
        }
    }
}
