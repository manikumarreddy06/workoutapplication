package com.myproject.myapplication

class constants {
    companion object{
fun defaultexerciselist():ArrayList<exercisemodel>{
val exerciselist=ArrayList<exercisemodel>()
    val jumpingjacks=exercisemodel(1,
        "jumping jacks",
        R.drawable.ic_jumping_jacks,
        false,
        false)
    exerciselist.add(jumpingjacks)


    val wallsit=exercisemodel(2,
        "wall sit",
        R.drawable.ic_wall_sit,
        false,
        false)
    exerciselist.add(wallsit)


    val pushups=exercisemodel(3,
        "pushups",
        R.drawable.ic_push_up,
        false,
        false)
    exerciselist.add(pushups)

    val Abdominalcrunch=exercisemodel(4,
        "Abdominal cruch",
        R.drawable.ic_abdominal_crunch,
        false,
        false)
    exerciselist.add(Abdominalcrunch)


    val stepUpOnChair=exercisemodel(5,
        "Step up on chair",
        R.drawable.ic_step_up_onto_chair,
        false,
        false)
    exerciselist.add(stepUpOnChair)


    val squat=exercisemodel(6,
        "Squat",
        R.drawable.ic_squat,
        false,
        false)
    exerciselist.add(squat)


    val TricepDiponchair=exercisemodel(7,
        "Tricep Dip on chair",
        R.drawable.ic_triceps_dip_on_chair,
        false,
        false)
    exerciselist.add(TricepDiponchair)


    val planck=exercisemodel(8,
        "Planck",
        R.drawable.ic_plank,
        false,
        false)
    exerciselist.add(planck)


    val HighkneesRunninginplace=exercisemodel(9,
        "High knees running in place",
        R.drawable.ic_high_knees_running_in_place,
        false,
        false)
    exerciselist.add(HighkneesRunninginplace)


    val lunges=exercisemodel(10,
        "Lunges",
        R.drawable.ic_lunge,
        false,
        false)
    exerciselist.add(lunges)


    val PushUpandrotation=exercisemodel(11,
        "Push up and rotation",
        R.drawable.ic_push_up_and_rotation,
        false,
        false)
    exerciselist.add(PushUpandrotation)


    val sideplanck=exercisemodel(12,
        "sideplanck",
        R.drawable.ic_side_plank,
        false,
        false)
    exerciselist.add(sideplanck)










    return exerciselist
}

    }
}