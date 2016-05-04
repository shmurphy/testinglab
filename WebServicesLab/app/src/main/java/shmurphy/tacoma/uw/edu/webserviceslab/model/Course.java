package shmurphy.tacoma.uw.edu.webserviceslab.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

/**
 * Created by shmurphy on 4/20/16.
 */
public class Course implements Serializable {

    String myCourseId;
    String mShortDescription;
    String mLongDescription;
    String mPrereqs;

    public static final String ID = "id", SHORT_DESC = "shortDesc",
            LONG_DESC = "longDesc", PRE_REQS = "prereqs";

    public Course(String theId, String theShortDesc, String theLongDesc, String thePrereqs) {
        myCourseId = theId;
        mShortDescription = theShortDesc;
        mLongDescription = theLongDesc;
        mPrereqs = thePrereqs;
    }


    /**
     * Parses the json string, returns an error message if unsuccessful.
     * Returns course list if success.
     * @param courseJSON
     * @return reason or null if successful.
     */
    public static String parseCourseJSON(String courseJSON, List<Course> courseList) {
        String reason = null;
        if (courseJSON != null) {
            try {
                JSONArray arr = new JSONArray(courseJSON);
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    Course course = new Course(obj.getString(Course.ID), obj.getString(Course.SHORT_DESC),
                            obj.getString(Course.LONG_DESC), obj.getString(Course.PRE_REQS));
                    courseList.add(course);
                }
            } catch (JSONException e) {
                reason =  "Unable to parse data, Reason: " + e.getMessage();
            }
        }
        return reason;
    }


    public String getMyCourseId() {
        return myCourseId;
    }

    public void setMyCourseId(String myCourseId) {
        this.myCourseId = myCourseId;
    }

    public String getmShortDescription() {
        return mShortDescription;
    }

    public void setmShortDescription(String mShortDescription) {
        this.mShortDescription = mShortDescription;
    }

    public String getmLongDescription() {
        return mLongDescription;
    }

    public void setmLongDescription(String mLongDescription) {
        this.mLongDescription = mLongDescription;
    }

    public String getmPrereqs() {
        return mPrereqs;
    }

    public void setmPrereqs(String mPrereqs) {
        this.mPrereqs = mPrereqs;
    }


}
