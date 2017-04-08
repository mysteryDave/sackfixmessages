package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class UnderlyingAmountComponent(noUnderlyingAmountsField:Option[NoUnderlyingAmountsField]=None,
                                     underlyingAmountsGroups: Option[List[UnderlyingAmountsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noUnderlyingAmountsField.map(_.value).getOrElse(0) != underlyingAmountsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoUnderlyingAmountsField.TagId,noUnderlyingAmountsField.map(_.value).getOrElse(0), underlyingAmountsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noUnderlyingAmountsField.foreach(fmt(b,_))
    underlyingAmountsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object UnderlyingAmountComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    UnderlyingAmountsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoUnderlyingAmountsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    UnderlyingAmountsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    UnderlyingAmountsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoUnderlyingAmountsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = UnderlyingAmountsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[UnderlyingAmountComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(UnderlyingAmountComponent(myFields.get(NoUnderlyingAmountsField.TagId).flatMap(f=>NoUnderlyingAmountsField.decode(f)),
        if (nextTagPosLookup.contains(NoUnderlyingAmountsField.TagId)) UnderlyingAmountsGroup.decode(flds, nextTagPosLookup(NoUnderlyingAmountsField.TagId)) else None))
    } else None
  }

    
}
     