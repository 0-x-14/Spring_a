package umc.jupy.apiPayload.exception.handler;

import umc.jupy.apiPayload.code.BaseErrorCode;
import umc.jupy.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {

        super(errorCode);
    }
}