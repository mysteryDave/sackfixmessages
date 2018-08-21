package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class MaturityRulesGroup(maturityRuleIDField:Option[MaturityRuleIDField]=None,
                              maturityMonthYearFormatField:Option[MaturityMonthYearFormatField]=None,
                              maturityMonthYearIncrementUnitsField:Option[MaturityMonthYearIncrementUnitsField]=None,
                              startMaturityMonthYearField:Option[StartMaturityMonthYearField]=None,
                              endMaturityMonthYearField:Option[EndMaturityMonthYearField]=None,
                              maturityMonthYearIncrementField:Option[MaturityMonthYearIncrementField]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    maturityRuleIDField.foreach(fmt(b,_))
    maturityMonthYearFormatField.foreach(fmt(b,_))
    maturityMonthYearIncrementUnitsField.foreach(fmt(b,_))
    startMaturityMonthYearField.foreach(fmt(b,_))
    endMaturityMonthYearField.foreach(fmt(b,_))
    maturityMonthYearIncrementField.foreach(fmt(b,_))
    b
  }

}
     
object MaturityRulesGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    MaturityRuleIDField.TagId, MaturityMonthYearFormatField.TagId, MaturityMonthYearIncrementUnitsField.TagId, StartMaturityMonthYearField.TagId, EndMaturityMonthYearField.TagId, 
    MaturityMonthYearIncrementField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==MaturityRuleIDField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[MaturityRulesGroup]=ArrayBuffer.empty[MaturityRulesGroup]):Option[List[MaturityRulesGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[MaturityRulesGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[MaturityRulesGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(MaturityRulesGroup(myFields.get(MaturityRuleIDField.TagId).flatMap(f=>MaturityRuleIDField.decode(f)),
          myFields.get(MaturityMonthYearFormatField.TagId).flatMap(f=>MaturityMonthYearFormatField.decode(f)),
          myFields.get(MaturityMonthYearIncrementUnitsField.TagId).flatMap(f=>MaturityMonthYearIncrementUnitsField.decode(f)),
          myFields.get(StartMaturityMonthYearField.TagId).flatMap(f=>StartMaturityMonthYearField.decode(f)),
          myFields.get(EndMaturityMonthYearField.TagId).flatMap(f=>EndMaturityMonthYearField.decode(f)),
          myFields.get(MaturityMonthYearIncrementField.TagId).flatMap(f=>MaturityMonthYearIncrementField.decode(f)))))
      } else (startPos, None)
    }
  }
    
}
     