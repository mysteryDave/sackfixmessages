package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class StrikeRulesGroup(strikeRuleIDField:Option[StrikeRuleIDField]=None,
                            startStrikePxRangeField:Option[StartStrikePxRangeField]=None,
                            endStrikePxRangeField:Option[EndStrikePxRangeField]=None,
                            strikeIncrementField:Option[StrikeIncrementField]=None,
                            strikeExerciseStyleField:Option[StrikeExerciseStyleField]=None,
                            maturityRulesComponent:Option[MaturityRulesComponent]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    strikeRuleIDField.foreach(fmt(b,_))
    startStrikePxRangeField.foreach(fmt(b,_))
    endStrikePxRangeField.foreach(fmt(b,_))
    strikeIncrementField.foreach(fmt(b,_))
    strikeExerciseStyleField.foreach(fmt(b,_))
    maturityRulesComponent.foreach(fmt(b,_))
    b
  }

}
     
object StrikeRulesGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    MaturityRulesComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    StrikeRuleIDField.TagId, StartStrikePxRangeField.TagId, EndStrikePxRangeField.TagId, StrikeIncrementField.TagId, StrikeExerciseStyleField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    MaturityRulesComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    MaturityRulesComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==StrikeRuleIDField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[StrikeRulesGroup]=ArrayBuffer.empty[StrikeRulesGroup]):Option[List[StrikeRulesGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[StrikeRulesGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[StrikeRulesGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(StrikeRulesGroup(myFields.get(StrikeRuleIDField.TagId).flatMap(f=>StrikeRuleIDField.decode(f)),
          myFields.get(StartStrikePxRangeField.TagId).flatMap(f=>StartStrikePxRangeField.decode(f)),
          myFields.get(EndStrikePxRangeField.TagId).flatMap(f=>EndStrikePxRangeField.decode(f)),
          myFields.get(StrikeIncrementField.TagId).flatMap(f=>StrikeIncrementField.decode(f)),
          myFields.get(StrikeExerciseStyleField.TagId).flatMap(f=>StrikeExerciseStyleField.decode(f)),
          MaturityRulesComponent.decode(flds, startPos))))
      } else (startPos, None)
    }
  }
    
}
     