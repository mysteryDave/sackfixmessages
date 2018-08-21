package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class DiscretionInstructionsComponent(discretionInstField:Option[DiscretionInstField]=None,
                                           discretionOffsetValueField:Option[DiscretionOffsetValueField]=None,
                                           discretionMoveTypeField:Option[DiscretionMoveTypeField]=None,
                                           discretionOffsetTypeField:Option[DiscretionOffsetTypeField]=None,
                                           discretionLimitTypeField:Option[DiscretionLimitTypeField]=None,
                                           discretionRoundDirectionField:Option[DiscretionRoundDirectionField]=None,
                                           discretionScopeField:Option[DiscretionScopeField]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    discretionInstField.foreach(fmt(b,_))
    discretionOffsetValueField.foreach(fmt(b,_))
    discretionMoveTypeField.foreach(fmt(b,_))
    discretionOffsetTypeField.foreach(fmt(b,_))
    discretionLimitTypeField.foreach(fmt(b,_))
    discretionRoundDirectionField.foreach(fmt(b,_))
    discretionScopeField.foreach(fmt(b,_))
    b
  }

}
     
object DiscretionInstructionsComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    DiscretionInstField.TagId, DiscretionOffsetValueField.TagId, DiscretionMoveTypeField.TagId, DiscretionOffsetTypeField.TagId, DiscretionLimitTypeField.TagId, 
    DiscretionRoundDirectionField.TagId, DiscretionScopeField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==DiscretionInstField.TagId 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[DiscretionInstructionsComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(DiscretionInstructionsComponent(myFields.get(DiscretionInstField.TagId).flatMap(f=>DiscretionInstField.decode(f)),
        myFields.get(DiscretionOffsetValueField.TagId).flatMap(f=>DiscretionOffsetValueField.decode(f)),
        myFields.get(DiscretionMoveTypeField.TagId).flatMap(f=>DiscretionMoveTypeField.decode(f)),
        myFields.get(DiscretionOffsetTypeField.TagId).flatMap(f=>DiscretionOffsetTypeField.decode(f)),
        myFields.get(DiscretionLimitTypeField.TagId).flatMap(f=>DiscretionLimitTypeField.decode(f)),
        myFields.get(DiscretionRoundDirectionField.TagId).flatMap(f=>DiscretionRoundDirectionField.decode(f)),
        myFields.get(DiscretionScopeField.TagId).flatMap(f=>DiscretionScopeField.decode(f))))
    } else None
  }

    
}
     